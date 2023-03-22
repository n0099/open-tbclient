package rx.internal.subscriptions;

import com.baidu.tieba.vra;
/* loaded from: classes9.dex */
public enum Unsubscribed implements vra {
    INSTANCE;

    @Override // com.baidu.tieba.vra
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.vra
    public void unsubscribe() {
    }
}
