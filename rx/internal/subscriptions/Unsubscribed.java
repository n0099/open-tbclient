package rx.internal.subscriptions;

import com.baidu.tieba.o6c;
/* loaded from: classes2.dex */
public enum Unsubscribed implements o6c {
    INSTANCE;

    @Override // com.baidu.tieba.o6c
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // com.baidu.tieba.o6c
    public void unsubscribe() {
    }
}
