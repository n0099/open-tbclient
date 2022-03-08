package com.google.android.exoplayer2.upstream.cache;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.AtomicFile;
import com.google.android.exoplayer2.util.ReusableBufferedOutputStream;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes7.dex */
public class CachedContentIndex {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String FILE_NAME = "cached_content_index.exi";
    public static final int FLAG_ENCRYPTED_INDEX = 1;
    public static final String TAG = "CachedContentIndex";
    public static final int VERSION = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final AtomicFile atomicFile;
    public ReusableBufferedOutputStream bufferedOutputStream;
    public boolean changed;
    public final Cipher cipher;
    public final boolean encrypt;
    public final SparseArray<String> idToKey;
    public final HashMap<String, CachedContent> keyToContent;
    public final SecretKeySpec secretKeySpec;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedContentIndex(File file) {
        this(file, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (byte[]) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (Util.SDK_INT == 18) {
                try {
                    return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
                } catch (Throwable unused) {
                }
            }
            return Cipher.getInstance("AES/CBC/PKCS5PADDING");
        }
        return (Cipher) invokeV.objValue;
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, sparseArray)) == null) {
            int size = sparseArray.size();
            int i2 = 0;
            int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
            if (keyAt < 0) {
                while (i2 < size && i2 == sparseArray.keyAt(i2)) {
                    i2++;
                }
                return i2;
            }
            return keyAt;
        }
        return invokeL.intValue;
    }

    private boolean readFile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, this)) != null) {
            return invokeV.booleanValue;
        }
        DataInputStream dataInputStream = null;
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
            DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
            try {
                if (dataInputStream2.readInt() != 1) {
                    Util.closeQuietly(dataInputStream2);
                    return false;
                }
                if ((dataInputStream2.readInt() & 1) != 0) {
                    if (this.cipher == null) {
                        Util.closeQuietly(dataInputStream2);
                        return false;
                    }
                    byte[] bArr = new byte[16];
                    dataInputStream2.readFully(bArr);
                    try {
                        this.cipher.init(2, this.secretKeySpec, new IvParameterSpec(bArr));
                        dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                } else {
                    if (this.encrypt) {
                        this.changed = true;
                    }
                    dataInputStream = dataInputStream2;
                }
                int readInt = dataInputStream.readInt();
                int i2 = 0;
                for (int i3 = 0; i3 < readInt; i3++) {
                    CachedContent cachedContent = new CachedContent(dataInputStream);
                    add(cachedContent);
                    i2 += cachedContent.headerHashCode();
                }
                if (dataInputStream.readInt() != i2) {
                    Util.closeQuietly(dataInputStream);
                    return false;
                }
                Util.closeQuietly(dataInputStream);
                return true;
            } catch (FileNotFoundException unused) {
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (IOException unused2) {
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                return false;
            } catch (Throwable th) {
                th = th;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    Util.closeQuietly(dataInputStream);
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        } catch (IOException unused4) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void writeFile() throws Cache.CacheException {
        DataOutputStream dataOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            DataOutputStream dataOutputStream2 = null;
            try {
                try {
                    OutputStream startWrite = this.atomicFile.startWrite();
                    if (this.bufferedOutputStream == null) {
                        this.bufferedOutputStream = new ReusableBufferedOutputStream(startWrite);
                    } else {
                        this.bufferedOutputStream.reset(startWrite);
                    }
                    dataOutputStream = new DataOutputStream(this.bufferedOutputStream);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e2) {
                e = e2;
            }
            try {
                dataOutputStream.writeInt(1);
                int i2 = 0;
                dataOutputStream.writeInt(this.encrypt ? 1 : 0);
                if (this.encrypt) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                    } catch (InvalidAlgorithmParameterException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e4) {
                        e = e4;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(this.keyToContent.size());
                for (CachedContent cachedContent : this.keyToContent.values()) {
                    cachedContent.writeToStream(dataOutputStream);
                    i2 += cachedContent.headerHashCode();
                }
                dataOutputStream.writeInt(i2);
                this.atomicFile.endWrite(dataOutputStream);
                Util.closeQuietly((Closeable) null);
            } catch (IOException e5) {
                e = e5;
                throw new Cache.CacheException(e);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                Util.closeQuietly(dataOutputStream2);
                throw th;
            }
        }
    }

    public CachedContent add(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            CachedContent cachedContent = this.keyToContent.get(str);
            return cachedContent == null ? addNew(str, -1L) : cachedContent;
        }
        return (CachedContent) invokeL.objValue;
    }

    public void addNew(CachedContent cachedContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cachedContent) == null) {
            add(cachedContent);
            this.changed = true;
        }
    }

    public int assignIdForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? add(str).id : invokeL.intValue;
    }

    public CachedContent get(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) ? this.keyToContent.get(str) : (CachedContent) invokeL.objValue;
    }

    public Collection<CachedContent> getAll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.keyToContent.values() : (Collection) invokeV.objValue;
    }

    public long getContentLength(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            CachedContent cachedContent = get(str);
            if (cachedContent == null) {
                return -1L;
            }
            return cachedContent.getLength();
        }
        return invokeL.longValue;
    }

    public String getKeyForId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? this.idToKey.get(i2) : (String) invokeI.objValue;
    }

    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.keyToContent.keySet() : (Set) invokeV.objValue;
    }

    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Assertions.checkState(!this.changed);
            if (readFile()) {
                return;
            }
            this.atomicFile.delete();
            this.keyToContent.clear();
            this.idToKey.clear();
        }
    }

    public void removeEmpty(String str) {
        CachedContent remove;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, str) == null) || (remove = this.keyToContent.remove(str)) == null) {
            return;
        }
        Assertions.checkState(remove.isEmpty());
        this.idToKey.remove(remove.id);
        this.changed = true;
    }

    public void setContentLength(String str, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048587, this, str, j2) == null) {
            CachedContent cachedContent = get(str);
            if (cachedContent != null) {
                if (cachedContent.getLength() != j2) {
                    cachedContent.setLength(j2);
                    this.changed = true;
                    return;
                }
                return;
            }
            addNew(str, j2);
        }
    }

    public void store() throws Cache.CacheException {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.changed) {
            writeFile();
            this.changed = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CachedContentIndex(File file, byte[] bArr) {
        this(file, bArr, bArr != null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((File) objArr2[0], (byte[]) objArr2[1], ((Boolean) objArr2[2]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public CachedContentIndex(File file, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {file, bArr, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.encrypt = z;
        if (bArr != null) {
            Assertions.checkArgument(bArr.length == 16);
            try {
                this.cipher = getCipher();
                this.secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            Assertions.checkState(!z);
            this.cipher = null;
            this.secretKeySpec = null;
        }
        this.keyToContent = new HashMap<>();
        this.idToKey = new SparseArray<>();
        this.atomicFile = new AtomicFile(new File(file, FILE_NAME));
    }

    private void add(CachedContent cachedContent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, cachedContent) == null) {
            this.keyToContent.put(cachedContent.key, cachedContent);
            this.idToKey.put(cachedContent.id, cachedContent.key);
        }
    }

    private CachedContent addNew(String str, long j2) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, this, str, j2)) == null) {
            CachedContent cachedContent = new CachedContent(getNewId(this.idToKey), str, j2);
            addNew(cachedContent);
            return cachedContent;
        }
        return (CachedContent) invokeLJ.objValue;
    }

    public void removeEmpty() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            ArrayList arrayList = new ArrayList();
            for (CachedContent cachedContent : this.keyToContent.values()) {
                if (cachedContent.isEmpty()) {
                    arrayList.add(cachedContent.key);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                removeEmpty((String) arrayList.get(i2));
            }
        }
    }
}
