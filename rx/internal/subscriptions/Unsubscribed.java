package rx.internal.subscriptions;

import com.baidu.tieba.pmb;
/* loaded from: classes2.dex */
public enum Unsubscribed implements pmb {
    INSTANCE;

    @Override // com.baidu.tieba.pmb
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.pmb
    public void unsubscribe() {
    }
}
