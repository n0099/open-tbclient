package okio;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes9.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Segment segment = this.prev;
            if (segment != this) {
                if (segment.owner) {
                    int i2 = this.limit - this.pos;
                    if (i2 > (8192 - segment.limit) + (segment.shared ? 0 : segment.pos)) {
                        return;
                    }
                    writeTo(this.prev, i2);
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
    public final Segment pop() {
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

    public final Segment push(Segment segment) {
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

    public final Segment sharedCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.shared = true;
            return new Segment(this.data, this.pos, this.limit, true, false);
        }
        return (Segment) invokeV.objValue;
    }

    public final Segment split(int i2) {
        InterceptResult invokeI;
        Segment take;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (i2 > 0 && i2 <= this.limit - this.pos) {
                if (i2 >= 1024) {
                    take = sharedCopy();
                } else {
                    take = SegmentPool.take();
                    System.arraycopy(this.data, this.pos, take.data, 0, i2);
                }
                take.limit = take.pos + i2;
                this.pos += i2;
                this.prev.push(take);
                return take;
            }
            throw new IllegalArgumentException();
        }
        return (Segment) invokeI.objValue;
    }

    public final Segment unsharedCopy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true) : (Segment) invokeV.objValue;
    }

    public final void writeTo(Segment segment, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, segment, i2) == null) {
            if (segment.owner) {
                int i3 = segment.limit;
                if (i3 + i2 > 8192) {
                    if (!segment.shared) {
                        int i4 = segment.pos;
                        if ((i3 + i2) - i4 <= 8192) {
                            byte[] bArr = segment.data;
                            System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                            segment.limit -= segment.pos;
                            segment.pos = 0;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                }
                System.arraycopy(this.data, this.pos, segment.data, segment.limit, i2);
                segment.limit += i2;
                this.pos += i2;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public Segment(byte[] bArr, int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.data = bArr;
        this.pos = i2;
        this.limit = i3;
        this.shared = z;
        this.owner = z2;
    }
}
