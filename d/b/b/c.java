package d.b.b;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes5.dex */
public interface c {

    /* loaded from: classes5.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f64255a;

        public a(@Nullable String str) {
            this.f64255a = str;
        }
    }

    @AnyThread
    void onOaidLoaded(@NonNull a aVar);
}
