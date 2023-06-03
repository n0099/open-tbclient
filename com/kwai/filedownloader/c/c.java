package com.kwai.filedownloader.c;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.filedownloader.e.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class c implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<c> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String apC;
    public boolean avS;
    public boolean awf;
    public final AtomicInteger awg;
    public final AtomicLong awh;
    public long awi;
    public String awj;
    public String awk;
    public int awl;
    public String filename;
    public int id;
    public String url;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1185740255, "Lcom/kwai/filedownloader/c/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1185740255, "Lcom/kwai/filedownloader/c/c;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.c.c.1
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

            public static c c(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(65537, null, parcel)) == null) ? new c(parcel) : (c) invokeL.objValue;
            }

            public static c[] cx(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(65538, null, i)) == null) ? new c[i] : (c[]) invokeI.objValue;
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ c createFromParcel(Parcel parcel) {
                return c(parcel);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ c[] newArray(int i) {
                return cx(i);
            }
        };
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.awh = new AtomicLong();
        this.awg = new AtomicInteger();
    }

    public c(Parcel parcel) {
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
        this.url = parcel.readString();
        this.apC = parcel.readString();
        this.awf = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.awg = new AtomicInteger(parcel.readByte());
        this.awh = new AtomicLong(parcel.readLong());
        this.awi = parcel.readLong();
        this.awj = parcel.readString();
        this.awk = parcel.readString();
        this.awl = parcel.readInt();
        this.avS = parcel.readByte() != 0;
    }

    private String wX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) ? this.awj : (String) invokeV.objValue;
    }

    public final boolean BW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.awf : invokeV.booleanValue;
    }

    public final byte Ca() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (byte) this.awg.get() : invokeV.byteValue;
    }

    public final boolean Cg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.avS : invokeV.booleanValue;
    }

    public final String DE() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (getTargetFilePath() == null) {
                return null;
            }
            return f.eF(getTargetFilePath());
        }
        return (String) invokeV.objValue;
    }

    public final ContentValues Ek() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", Integer.valueOf(getId()));
            contentValues.put("url", getUrl());
            contentValues.put("path", getPath());
            contentValues.put("status", Byte.valueOf(Ca()));
            contentValues.put("sofar", Long.valueOf(Em()));
            contentValues.put("total", Long.valueOf(getTotal()));
            contentValues.put(StatConstants.KEY_EXT_ERR_MSG, wX());
            contentValues.put("etag", En());
            contentValues.put("connectionCount", Integer.valueOf(Eo()));
            contentValues.put("pathAsDirectory", Boolean.valueOf(BW()));
            if (BW() && getFilename() != null) {
                contentValues.put(BreakpointSQLiteKey.FILENAME, getFilename());
            }
            return contentValues;
        }
        return (ContentValues) invokeV.objValue;
    }

    public final long Em() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.awh.get() : invokeV.longValue;
    }

    public final String En() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.awk : (String) invokeV.objValue;
    }

    public final int Eo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.awl : invokeV.intValue;
    }

    public final void Ep() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.awl = 1;
        }
    }

    public final void Z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j) == null) {
            this.awh.set(j);
        }
    }

    public final void aa(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048586, this, j) == null) {
            this.awh.addAndGet(j);
        }
    }

    public final void ab(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048587, this, j) == null) {
            this.avS = j > 2147483647L;
            this.awi = j;
        }
    }

    public final void cw(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.awl = i;
        }
    }

    public final void d(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
            this.apC = str;
            this.awf = z;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final void e(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048591, this, b) == null) {
            this.awg.set(b);
        }
    }

    public final void eA(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.awj = str;
        }
    }

    public final void eB(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            this.filename = str;
        }
    }

    public final void ez(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.awk = str;
        }
    }

    public final String getFilename() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.filename : (String) invokeV.objValue;
    }

    public final int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.id : invokeV.intValue;
    }

    public final String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.apC : (String) invokeV.objValue;
    }

    public final String getTargetFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? f.a(getPath(), BW(), getFilename()) : (String) invokeV.objValue;
    }

    public final long getTotal() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.awi : invokeV.longValue;
    }

    public final String getUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.url : (String) invokeV.objValue;
    }

    public final boolean isChunked() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.awi == -1 : invokeV.booleanValue;
    }

    public final void setId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.id = i;
        }
    }

    public final void setUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.url = str;
        }
    }

    public final String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? f.h("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.apC, Integer.valueOf(this.awg.get()), this.awh, Long.valueOf(this.awi), this.awk, super.toString()) : (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048605, this, parcel, i) == null) {
            parcel.writeInt(this.id);
            parcel.writeString(this.url);
            parcel.writeString(this.apC);
            parcel.writeByte(this.awf ? (byte) 1 : (byte) 0);
            parcel.writeString(this.filename);
            parcel.writeByte((byte) this.awg.get());
            parcel.writeLong(this.awh.get());
            parcel.writeLong(this.awi);
            parcel.writeString(this.awj);
            parcel.writeString(this.awk);
            parcel.writeInt(this.awl);
            parcel.writeByte(this.avS ? (byte) 1 : (byte) 0);
        }
    }
}
