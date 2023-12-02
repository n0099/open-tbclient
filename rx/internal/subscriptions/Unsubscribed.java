package rx.internal.subscriptions;

import com.baidu.tieba.koc;
/* loaded from: classes2.dex */
public enum Unsubscribed implements koc {
    INSTANCE;

    @Override // com.baidu.tieba.koc
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.koc
    public void unsubscribe() {
    }
}
