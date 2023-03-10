package com.matrix.observer.push;

/**
 * 具体观察者角色
 *
 * @author : cui_feng
 * @since : 2023-01-12 10:38
 */
public class ConcreteObserver implements Observer{

    //观察者的状态
    private String observerState;

    @Override
    public void update(String state) {
         // 更新观察者的状态，使其与目标的状态保持一致
        observerState = state;
        System.out.println("状态为："+ observerState);
    }
}
