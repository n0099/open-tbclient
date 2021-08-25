package com.kwai.filedownloader.message;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.message.d;
import com.kwai.filedownloader.message.h;
/* loaded from: classes10.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MessageSnapshot> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f74098a;

    /* renamed from: b  reason: collision with root package name */
    public final int f74099b;

    /* loaded from: classes10.dex */
    public static class NoFieldException extends IllegalStateException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.f.f.a("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.m()), Byte.valueOf(messageSnapshot.b()), messageSnapshot.getClass().getName()));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, messageSnapshot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface a {
        MessageSnapshot l();
    }

    /* loaded from: classes10.dex */
    public static class b extends MessageSnapshot {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Parcel parcel) {
            super(parcel);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwai.filedownloader.message.c
        public byte b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return (byte) 6;
            }
            return invokeV.byteValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1792812011, "Lcom/kwai/filedownloader/message/MessageSnapshot;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1792812011, "Lcom/kwai/filedownloader/message/MessageSnapshot;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MessageSnapshot>() { // from class: com.kwai.filedownloader.message.MessageSnapshot.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public MessageSnapshot createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                MessageSnapshot jVar;
                MessageSnapshot messageSnapshot;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeL = interceptable2.invokeL(1048576, this, parcel)) != null) {
                    return (MessageSnapshot) invokeL.objValue;
                }
                boolean z = parcel.readByte() == 1;
                byte readByte = parcel.readByte();
                if (readByte == -4) {
                    jVar = z ? new d.j(parcel) : new h.j(parcel);
                } else if (readByte == -3) {
                    jVar = z ? new d.b(parcel) : new h.b(parcel);
                } else if (readByte == -1) {
                    jVar = z ? new d.C2030d(parcel) : new h.d(parcel);
                } else if (readByte == 1) {
                    jVar = z ? new d.f(parcel) : new h.f(parcel);
                } else if (readByte == 2) {
                    jVar = z ? new d.c(parcel) : new h.c(parcel);
                } else if (readByte == 3) {
                    jVar = z ? new d.g(parcel) : new h.g(parcel);
                } else if (readByte == 5) {
                    jVar = z ? new d.h(parcel) : new h.C2031h(parcel);
                } else if (readByte != 6) {
                    messageSnapshot = null;
                    if (messageSnapshot == null) {
                        messageSnapshot.f74098a = z;
                        return messageSnapshot;
                    }
                    throw new IllegalStateException("Can't restore the snapshot because unknown status: " + ((int) readByte));
                } else {
                    jVar = new b(parcel);
                }
                messageSnapshot = jVar;
                if (messageSnapshot == null) {
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MessageSnapshot[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new MessageSnapshot[i2] : (MessageSnapshot[]) invokeI.objValue;
            }
        };
    }

    public MessageSnapshot(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f74099b = i2;
    }

    public MessageSnapshot(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f74099b = parcel.readInt();
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new NoFieldException("getSmallSofarBytes", this);
        }
        return invokeV.intValue;
    }

    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            throw new NoFieldException("getSmallTotalBytes", this);
        }
        return invokeV.intValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new NoFieldException("getLargeTotalBytes", this);
        }
        return invokeV.longValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new NoFieldException("isReusedDownloadedFile", this);
        }
        return invokeV.booleanValue;
    }

    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new NoFieldException("getFileName", this);
        }
        return (String) invokeV.objValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new NoFieldException("isResuming", this);
        }
        return invokeV.booleanValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new NoFieldException("getEtag", this);
        }
        return (String) invokeV.objValue;
    }

    public long i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new NoFieldException("getLargeSofarBytes", this);
        }
        return invokeV.longValue;
    }

    public Throwable j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            throw new NoFieldException("getThrowable", this);
        }
        return (Throwable) invokeV.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new NoFieldException("getRetryingTimes", this);
        }
        return invokeV.intValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f74099b : invokeV.intValue;
    }

    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f74098a : invokeV.booleanValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i2) == null) {
            parcel.writeByte(this.f74098a ? (byte) 1 : (byte) 0);
            parcel.writeByte(b());
            parcel.writeInt(this.f74099b);
        }
    }
}
