package d.f.d.d;

import com.google.common.hash.Funnel;
import com.google.common.hash.HashCode;
/* loaded from: classes8.dex */
public interface e {
    <T> HashCode hashObject(T t, Funnel<? super T> funnel);

    f newHasher();
}
