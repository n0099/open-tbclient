package rx.internal.subscriptions;

import com.baidu.tieba.rcc;
/* loaded from: classes2.dex */
public enum Unsubscribed implements rcc {
    INSTANCE;

    @Override // com.baidu.tieba.rcc
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.rcc
    public void unsubscribe() {
    }
}
