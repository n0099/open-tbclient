package rx.internal.subscriptions;

import com.baidu.tieba.zac;
/* loaded from: classes2.dex */
public enum Unsubscribed implements zac {
    INSTANCE;

    @Override // com.baidu.tieba.zac
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.zac
    public void unsubscribe() {
    }
}
