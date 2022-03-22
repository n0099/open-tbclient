package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public final class Segment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public void compact() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Segment segment = this.prev;
            if (segment != this) {
                if (segment.owner) {
                    int i = this.limit - this.pos;
                    if (i > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                        return;
                    }
                    writeTo(this.prev, i);
                    pop();
                    SegmentPool.recycle(this);
                    return;
                }
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Nullable
    public Segment pop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Segment segment = this.next;
            if (segment == this) {
                segment = null;
            }
            Segment segment2 = this.prev;
            segment2.next = this.next;
            this.next.prev = segment2;
            this.next = null;
            this.prev = null;
            return segment;
        }
        return (Segment) invokeV.objValue;
    }

    public Segment push(Segment segment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, segment)) == null) {
            segment.prev = this;
            segment.next = this.next;
            this.next.prev = segment;
            this.next = segment;
            return segment;
        }
        return (Segment) invokeL.objValue;
    }

    public Segment sharedCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.shared = true;
            return new Segment(this.data, this.pos, this.limit, true, false);
        }
        return (Segment) invokeV.objValue;
    }

    public Segment split(int i) {
        InterceptResult invokeI;
        Segment take;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (i > 0 && i <= this.limit - this.pos) {
                if (i >= 1024) {
                    take = sharedCopy();
                } else {
                    take = SegmentPool.take();
                    System.arraycopy(this.data, this.pos, take.data, 0, i);
                }
                take.limit = take.pos + i;
                this.pos += i;
                this.prev.push(take);
                return take;
            }
            throw new IllegalArgumentException();
        }
        return (Segment) invokeI.objValue;
    }

    public Segment unsharedCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true) : (Segment) invokeV.objValue;
    }

    public void writeTo(Segment segment, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, segment, i) == null) {
            if (segment.owner) {
                int i2 = segment.limit;
                if (i2 + i > 8192) {
                    if (!segment.shared) {
                        int i3 = segment.pos;
                        if ((i2 + i) - i3 <= 8192) {
                            byte[] bArr = segment.data;
                            System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                            segment.limit -= segment.pos;
                            segment.pos = 0;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.arraycopy(this.data, this.pos, segment.data, segment.limit, i);
                segment.limit += i;
                this.pos += i;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
