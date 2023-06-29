package rx.internal.subscriptions;

import com.baidu.tieba.etb;
/* loaded from: classes2.dex */
public enum Unsubscribed implements etb {
    INSTANCE;

    @Override // com.baidu.tieba.etb
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.etb
    public void unsubscribe() {
    }
}
