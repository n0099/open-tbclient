package com.idlefish.flutterboost.interfaces;
/* loaded from: classes4.dex */
public interface IContainerRecord extends IOperateSyncer {
    long creatTime();

    IFlutterViewContainer getContainer();

    int getState();

    String uniqueId();
}
