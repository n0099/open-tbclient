package rx.internal.subscriptions;

import com.baidu.tieba.pjc;
/* loaded from: classes2.dex */
public enum Unsubscribed implements pjc {
    INSTANCE;

    @Override // com.baidu.tieba.pjc
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.pjc
    public void unsubscribe() {
    }
}
