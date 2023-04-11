package rx.internal.subscriptions;

import com.baidu.tieba.m1b;
/* loaded from: classes9.dex */
public enum Unsubscribed implements m1b {
    INSTANCE;

    @Override // com.baidu.tieba.m1b
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.m1b
    public void unsubscribe() {
    }
}
