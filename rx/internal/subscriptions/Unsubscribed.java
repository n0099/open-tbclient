package rx.internal.subscriptions;

import com.baidu.tieba.u1b;
/* loaded from: classes9.dex */
public enum Unsubscribed implements u1b {
    INSTANCE;

    @Override // com.baidu.tieba.u1b
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.u1b
    public void unsubscribe() {
    }
}
