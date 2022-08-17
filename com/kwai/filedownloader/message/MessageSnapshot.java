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
/* loaded from: classes5.dex */
public abstract class MessageSnapshot implements Parcelable, c {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MessageSnapshot> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean avS;
    public final int id;

    /* loaded from: classes5.dex */
    public static class NoFieldException extends IllegalStateException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoFieldException(String str, MessageSnapshot messageSnapshot) {
            super(com.kwai.filedownloader.e.f.h("There isn't a field for '%s' in this message %d %d %s", str, Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Ca()), messageSnapshot.getClass().getName()));
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, messageSnapshot};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        MessageSnapshot Ef();
    }

    /* loaded from: classes5.dex */
    public static class b extends MessageSnapshot {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Ca() {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x009b  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public static MessageSnapshot a(Parcel parcel) {
                InterceptResult invokeL;
                MessageSnapshot jVar;
                MessageSnapshot messageSnapshot;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeL = interceptable2.invokeL(65537, null, parcel)) != null) {
                    return (MessageSnapshot) invokeL.objValue;
                }
                boolean z = parcel.readByte() == 1;
                byte readByte = parcel.readByte();
                if (readByte == -4) {
                    jVar = z ? new d.j(parcel) : new h.j(parcel);
                } else if (readByte == -3) {
                    jVar = z ? new d.b(parcel) : new h.b(parcel);
                } else if (readByte == -1) {
                    jVar = z ? new d.C0413d(parcel) : new h.d(parcel);
                } else if (readByte == 1) {
                    jVar = z ? new d.f(parcel) : new h.f(parcel);
                } else if (readByte == 2) {
                    jVar = z ? new d.c(parcel) : new h.c(parcel);
                } else if (readByte == 3) {
                    jVar = z ? new d.g(parcel) : new h.g(parcel);
                } else if (readByte == 5) {
                    jVar = z ? new d.h(parcel) : new h.C0414h(parcel);
                } else if (readByte != 6) {
                    messageSnapshot = null;
                    if (messageSnapshot == null) {
                        messageSnapshot.avS = z;
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

            public static MessageSnapshot[] ct(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(65538, null, i)) == null) ? new MessageSnapshot[i] : (MessageSnapshot[]) invokeI.objValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MessageSnapshot createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MessageSnapshot[] newArray(int i) {
                return ct(i);
            }
        };
    }

    public MessageSnapshot(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.id = i;
    }

    public MessageSnapshot(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.id = parcel.readInt();
    }

    public int Ce() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new NoFieldException("getRetryingTimes", this);
        }
        return invokeV.intValue;
    }

    public final boolean Cg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.avS : invokeV.booleanValue;
    }

    public boolean DR() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            throw new NoFieldException("isResuming", this);
        }
        return invokeV.booleanValue;
    }

    public int DZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            throw new NoFieldException("getSmallSofarBytes", this);
        }
        return invokeV.intValue;
    }

    public int Ea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            throw new NoFieldException("getSmallTotalBytes", this);
        }
        return invokeV.intValue;
    }

    public long Eb() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            throw new NoFieldException("getLargeTotalBytes", this);
        }
        return invokeV.longValue;
    }

    public boolean Ec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            throw new NoFieldException("isReusedDownloadedFile", this);
        }
        return invokeV.booleanValue;
    }

    public long Ed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            throw new NoFieldException("getLargeSofarBytes", this);
        }
        return invokeV.longValue;
    }

    public Throwable Ee() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            throw new NoFieldException("getThrowable", this);
        }
        return (Throwable) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public String getEtag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            throw new NoFieldException("getEtag", this);
        }
        return (String) invokeV.objValue;
    }

    public String getFileName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            throw new NoFieldException("getFileName", this);
        }
        return (String) invokeV.objValue;
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.id : invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048589, this, parcel, i) == null) {
            parcel.writeByte(this.avS ? (byte) 1 : (byte) 0);
            parcel.writeByte(Ca());
            parcel.writeInt(this.id);
        }
    }
}
