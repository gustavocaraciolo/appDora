import { Component, OnInit, Input, EventEmitter, Output } from '@angular/core';
import {trigger, state, style, transition, animate} from '@angular/animations';
import {Produto} from "../../produto";

@Component({
  selector: 'jhi-carrinho-vendas-item',
  templateUrl: './carrinho-vendas-item.component.html',
    animations: [
        trigger('menuItemAppeared', [
            state('ready', style({opacity: 1})),
            transition('void => ready', [
                style({opacity: 0, transform: 'translateY(-20px)'}),
                animate('300ms 0s ease-in')
            ])
        ])
    ]
})
export class CarrinhoVendasItemComponent implements OnInit {

    menuItemState = 'ready'

    @Input() menuItem: Produto
    @Output() add = new EventEmitter()

    constructor() {
    }

    ngOnInit() {
    }

    emitAddEvent() {
        this.add.emit(this.menuItem)
    }
}
