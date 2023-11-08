const app = new Vue({
    el: '#app',
    data: {
        gameStarted: false,
        gameOver: false,
        player: {},
        enemy: {},
        selectedAction: 'attack',
        selectedOption: 1,
        attackOptions: [
            { value: 1, text: 'Attack 1' },
            { value: 2, text: 'Attack 2' },
            { value: 3, text: 'Attack 3' },
            { value: 4, text: 'Attack 4' },
            { value: 5, text: 'Attack 5' },
        ],
        buffDebuffOptions: [
            { value: 1, text: 'Type 1' },
            { value: 2, text: 'Type 2' },
            { value: 3, text: 'Type 3' },
            { value: 4, text: 'Type 4' },
            { value: 5, text: 'Type 5' },
        ],
        attackPreviews: [
            'Attack 1 deals moderate damage.',
            'Attack 2 deals low damage but has a chance to stun the enemy.',
            'Attack 3 deals high damage but has a lower accuracy.',
            'Attack 4 deals low damage but has a chance to poison the enemy.',
            'Attack 5 deals low damage and heals the player slightly.',
        ],
    },
    methods: {
        async startGame() {
            const response = await fetch('/api/game/start', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            const characters = await response.json();
            this.gameStarted = true;
            this.gameOver = false;
            this.player = characters[0];
            this.enemy = characters[1];
        },
        async performAction() {
            const response = await fetch('/api/game/action', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ actionType: this.selectedAction, option: parseInt(this.selectedOption) }),
            });

            if (response.status === 418) {
                this.gameOver = true;
            }

            const characters = await response.json();
            this.player = characters[0];
            this.enemy = characters[1];
        },
    },
});