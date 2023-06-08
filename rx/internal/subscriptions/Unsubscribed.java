package rx.internal.subscriptions;

import com.baidu.tieba.umb;
/* loaded from: classes2.dex */
public enum Unsubscribed implements umb {
    INSTANCE;

    @Override // com.baidu.tieba.umb
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.umb
    public void unsubscribe() {
    }
}
