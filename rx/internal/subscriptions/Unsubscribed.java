package rx.internal.subscriptions;

import com.baidu.tieba.e1c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements e1c {
    INSTANCE;

    @Override // com.baidu.tieba.e1c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.e1c
    public void unsubscribe() {
    }
}
