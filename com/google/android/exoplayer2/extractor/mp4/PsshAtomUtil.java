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
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uuid, bArr)) == null) ? buildPsshAtom(uuid, null, bArr) : (byte[]) invokeLL.objValue;
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
            if (parsableByteArray.readInt() == parsableByteArray.bytesLeft() + 4 && parsableByteArray.readInt() == Atom.TYPE_pssh) {
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
            return null;
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
            if (parsePsshAtom == null) {
                return null;
            }
            return parsePsshAtom.uuid;
        }
        return (UUID) invokeL.objValue;
    }

    public static int parseVersion(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, bArr)) == null) {
            PsshAtom parsePsshAtom = parsePsshAtom(bArr);
            if (parsePsshAtom == null) {
                return -1;
            }
            return parsePsshAtom.version;
        }
        return invokeL.intValue;
    }

    public static byte[] buildPsshAtom(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, uuid, uuidArr, bArr)) == null) {
            boolean z = uuidArr != null;
            int length = bArr != null ? bArr.length : 0;
            int i = length + 32;
            if (z) {
                i += (uuidArr.length * 16) + 4;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i);
            allocate.putInt(i);
            allocate.putInt(Atom.TYPE_pssh);
            allocate.putInt(z ? 16777216 : 0);
            allocate.putLong(uuid.getMostSignificantBits());
            allocate.putLong(uuid.getLeastSignificantBits());
            if (z) {
                allocate.putInt(uuidArr.length);
                for (UUID uuid2 : uuidArr) {
                    allocate.putLong(uuid2.getMostSignificantBits());
                    allocate.putLong(uuid2.getLeastSignificantBits());
                }
            }
            if (length != 0) {
                allocate.putInt(bArr.length);
                allocate.put(bArr);
            }
            return allocate.array();
        }
        return (byte[]) invokeLLL.objValue;
    }
}
