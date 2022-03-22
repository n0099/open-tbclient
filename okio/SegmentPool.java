package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public final class SegmentPool {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MAX_SIZE = 65536;
    public static long byteCount;
    @Nullable
    public static Segment next;
    public transient /* synthetic */ FieldHolder $fh;

    public SegmentPool() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void recycle(Segment segment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, segment) == null) {
            if (segment.next == null && segment.prev == null) {
                if (segment.shared) {
                    return;
                }
                synchronized (SegmentPool.class) {
                    if (byteCount + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                        return;
                    }
                    byteCount += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    segment.next = next;
                    segment.limit = 0;
                    segment.pos = 0;
                    next = segment;
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public static Segment take() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (SegmentPool.class) {
                if (next != null) {
                    Segment segment = next;
                    next = segment.next;
                    segment.next = null;
                    byteCount -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    return segment;
                }
                return new Segment();
            }
        }
        return (Segment) invokeV.objValue;
    }
}
