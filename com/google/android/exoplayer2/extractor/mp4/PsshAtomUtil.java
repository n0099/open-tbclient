package com.google.android.exoplayer2.extractor.mp4;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes7.dex */
public final class PsshAtomUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "PsshAtomUtil";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class PsshAtom {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final byte[] schemeData;
        public final UUID uuid;
        public final int version;

        public PsshAtom(UUID uuid, int i, byte[] bArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {uuid, Integer.valueOf(i), bArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.uuid = uuid;
            this.version = i;
            this.schemeData = bArr;
        }
    }

    public PsshAtomUtil() {
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

    public static byte[] buildPsshAtom(UUID uuid, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uuid, bArr)) == null) {
            return buildPsshAtom(uuid, null, bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public static byte[] buildPsshAtom(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        InterceptResult invokeLLL;
        boolean z;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, uuid, uuidArr, bArr)) == null) {
            if (uuidArr != null) {
                z = true;
            } else {
                z = false;
            }
            if (bArr != null) {
                i = bArr.length;
            } else {
                i = 0;
            }
            int i3 = i + 32;
            if (z) {
                i3 += (uuidArr.length * 16) + 4;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i3);
            allocate.putInt(i3);
            allocate.putInt(Atom.TYPE_pssh);
            if (z) {
                i2 = 16777216;
            } else {
                i2 = 0;
            }
            allocate.putInt(i2);
            allocate.putLong(uuid.getMostSignificantBits());
            allocate.putLong(uuid.getLeastSignificantBits());
            if (z) {
                allocate.putInt(uuidArr.length);
                for (UUID uuid2 : uuidArr) {
                    allocate.putLong(uuid2.getMostSignificantBits());
                    allocate.putLong(uuid2.getLeastSignificantBits());
                }
            }
            if (i != 0) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            return allocate.array();
        }
        return (byte[]) invokeLLL.objValue;
    }

    public static PsshAtom parsePsshAtom(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
            if (parsableByteArray.limit() < 32) {
                return null;
            }
            parsableByteArray.setPosition(0);
            if (parsableByteArray.readInt() != parsableByteArray.bytesLeft() + 4 || parsableByteArray.readInt() != Atom.TYPE_pssh) {
                return null;
            }
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            if (parseFullAtomVersion > 1) {
                Log.w(TAG, "Unsupported pssh version: " + parseFullAtomVersion);
                return null;
            }
            UUID uuid = new UUID(parsableByteArray.readLong(), parsableByteArray.readLong());
            if (parseFullAtomVersion == 1) {
                parsableByteArray.skipBytes(parsableByteArray.readUnsignedIntToInt() * 16);
            }
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt != parsableByteArray.bytesLeft()) {
                return null;
            }
            byte[] bArr2 = new byte[readUnsignedIntToInt];
            parsableByteArray.readBytes(bArr2, 0, readUnsignedIntToInt);
            return new PsshAtom(uuid, parseFullAtomVersion, bArr2);
        }
        return (PsshAtom) invokeL.objValue;
    }

    public static byte[] parseSchemeSpecificData(byte[] bArr, UUID uuid) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bArr, uuid)) == null) {
            PsshAtom parsePsshAtom = parsePsshAtom(bArr);
            if (parsePsshAtom == null) {
                return null;
            }
            if (uuid == null || uuid.equals(parsePsshAtom.uuid)) {
                return parsePsshAtom.schemeData;
            }
            Log.w(TAG, "UUID mismatch. Expected: " + uuid + ", got: " + parsePsshAtom.uuid + ".");
            return null;
        }
        return (byte[]) invokeLL.objValue;
    }

    public static UUID parseUuid(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, bArr)) == null) {
            PsshAtom parsePsshAtom = parsePsshAtom(bArr);
            if (parsePsshAtom != null) {
                return parsePsshAtom.uuid;
            }
            return null;
        }
        return (UUID) invokeL.objValue;
    }

    public static int parseVersion(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            PsshAtom parsePsshAtom = parsePsshAtom(bArr);
            if (parsePsshAtom != null) {
                return parsePsshAtom.version;
            }
            return -1;
        }
        return invokeL.intValue;
    }
}
