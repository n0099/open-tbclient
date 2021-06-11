package d.b.b;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes6.dex */
public interface c {

    /* loaded from: classes6.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final String f68715a;

        public a(@Nullable String str) {
            this.f68715a = str;
        }
    }

    @AnyThread
    void onOaidLoaded(@NonNull a aVar);
}
