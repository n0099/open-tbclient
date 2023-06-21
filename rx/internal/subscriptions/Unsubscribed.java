package rx.internal.subscriptions;

import com.baidu.tieba.nob;
/* loaded from: classes2.dex */
public enum Unsubscribed implements nob {
    INSTANCE;

    @Override // com.baidu.tieba.nob
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.nob
    public void unsubscribe() {
    }
}
