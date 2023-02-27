package rx.internal.subscriptions;

import com.baidu.tieba.zma;
/* loaded from: classes9.dex */
public enum Unsubscribed implements zma {
    INSTANCE;

    @Override // com.baidu.tieba.zma
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.zma
    public void unsubscribe() {
    }
}
