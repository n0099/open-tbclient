package rx.internal.subscriptions;

import com.baidu.tieba.o7b;
/* loaded from: classes10.dex */
public enum Unsubscribed implements o7b {
    INSTANCE;

    @Override // com.baidu.tieba.o7b
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.o7b
    public void unsubscribe() {
    }
}
