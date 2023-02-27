package com.google.android.exoplayer2.upstream.cache;

import android.util.Log;
import android.util.SparseArray;
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
    public static final String FILE_NAME = "cached_content_index.exi";
    public static final int FLAG_ENCRYPTED_INDEX = 1;
    public static final String TAG = "CachedContentIndex";
    public static final int VERSION = 1;
    public final AtomicFile atomicFile;
    public ReusableBufferedOutputStream bufferedOutputStream;
    public boolean changed;
    public final Cipher cipher;
    public final boolean encrypt;
    public final SparseArray<String> idToKey;
    public final HashMap<String, CachedContent> keyToContent;
    public final SecretKeySpec secretKeySpec;

    public CachedContentIndex(File file) {
        this(file, null);
    }

    private void add(CachedContent cachedContent) {
        this.keyToContent.put(cachedContent.key, cachedContent);
        this.idToKey.put(cachedContent.id, cachedContent.key);
    }

    public static int getNewId(SparseArray<String> sparseArray) {
        int keyAt;
        int size = sparseArray.size();
        int i = 0;
        if (size == 0) {
            keyAt = 0;
        } else {
            keyAt = sparseArray.keyAt(size - 1) + 1;
        }
        if (keyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            return i;
        }
        return keyAt;
    }

    public void addNew(CachedContent cachedContent) {
        add(cachedContent);
        this.changed = true;
    }

    public int assignIdForKey(String str) {
        return add(str).id;
    }

    public CachedContent get(String str) {
        return this.keyToContent.get(str);
    }

    public long getContentLength(String str) {
        CachedContent cachedContent = get(str);
        if (cachedContent == null) {
            return -1L;
        }
        return cachedContent.getLength();
    }

    public String getKeyForId(int i) {
        return this.idToKey.get(i);
    }

    public void removeEmpty(String str) {
        CachedContent remove = this.keyToContent.remove(str);
        if (remove != null) {
            Assertions.checkState(remove.isEmpty());
            this.idToKey.remove(remove.id);
            this.changed = true;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CachedContentIndex(File file, byte[] bArr) {
        this(file, bArr, r0);
        boolean z;
        if (bArr != null) {
            z = true;
        } else {
            z = false;
        }
    }

    private CachedContent addNew(String str, long j) {
        CachedContent cachedContent = new CachedContent(getNewId(this.idToKey), str, j);
        addNew(cachedContent);
        return cachedContent;
    }

    public void setContentLength(String str, long j) {
        CachedContent cachedContent = get(str);
        if (cachedContent != null) {
            if (cachedContent.getLength() != j) {
                cachedContent.setLength(j);
                this.changed = true;
                return;
            }
            return;
        }
        addNew(str, j);
    }

    public CachedContentIndex(File file, byte[] bArr, boolean z) {
        this.encrypt = z;
        if (bArr != null) {
            Assertions.checkArgument(bArr.length == 16);
            try {
                this.cipher = getCipher();
                this.secretKeySpec = new SecretKeySpec(bArr, "AES");
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                throw new IllegalStateException(e);
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

    public static Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (Util.SDK_INT == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public Collection<CachedContent> getAll() {
        return this.keyToContent.values();
    }

    public Set<String> getKeys() {
        return this.keyToContent.keySet();
    }

    public void load() {
        Assertions.checkState(!this.changed);
        if (!readFile()) {
            this.atomicFile.delete();
            this.keyToContent.clear();
            this.idToKey.clear();
        }
    }

    public void store() throws Cache.CacheException {
        if (!this.changed) {
            return;
        }
        writeFile();
        this.changed = false;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x009a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:49:0x009a */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readFile() {
        DataInputStream dataInputStream;
        IOException e;
        DataInputStream dataInputStream2;
        DataInputStream dataInputStream3 = null;
        try {
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.atomicFile.openRead());
                dataInputStream = new DataInputStream(bufferedInputStream);
                try {
                    if (dataInputStream.readInt() != 1) {
                        Util.closeQuietly(dataInputStream);
                        return false;
                    }
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.cipher == null) {
                            Util.closeQuietly(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.cipher.init(2, this.secretKeySpec, new IvParameterSpec(bArr));
                            dataInputStream3 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.cipher));
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
                        dataInputStream3 = dataInputStream;
                    }
                    int readInt = dataInputStream3.readInt();
                    int i = 0;
                    for (int i2 = 0; i2 < readInt; i2++) {
                        CachedContent cachedContent = new CachedContent(dataInputStream3);
                        add(cachedContent);
                        i += cachedContent.headerHashCode();
                    }
                    if (dataInputStream3.readInt() != i) {
                        Util.closeQuietly(dataInputStream3);
                        return false;
                    }
                    Util.closeQuietly(dataInputStream3);
                    return true;
                } catch (FileNotFoundException unused) {
                    dataInputStream3 = dataInputStream;
                    if (dataInputStream3 != null) {
                        Util.closeQuietly(dataInputStream3);
                    }
                    return false;
                } catch (IOException e4) {
                    e = e4;
                    Log.e(TAG, "Error reading cache content index file.", e);
                    if (dataInputStream != null) {
                        Util.closeQuietly(dataInputStream);
                    }
                    return false;
                }
            } catch (Throwable th) {
                th = th;
                dataInputStream3 = dataInputStream2;
                if (dataInputStream3 != null) {
                    Util.closeQuietly(dataInputStream3);
                }
                throw th;
            }
        } catch (FileNotFoundException unused2) {
        } catch (IOException e5) {
            dataInputStream = dataInputStream3;
            e = e5;
        } catch (Throwable th2) {
            th = th2;
            if (dataInputStream3 != null) {
            }
            throw th;
        }
    }

    private void writeFile() throws Cache.CacheException {
        DataOutputStream dataOutputStream;
        int i;
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
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(1);
            int i2 = 0;
            if (this.encrypt) {
                i = 1;
            } else {
                i = 0;
            }
            dataOutputStream.writeInt(i);
            if (this.encrypt) {
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                dataOutputStream.write(bArr);
                try {
                    this.cipher.init(1, this.secretKeySpec, new IvParameterSpec(bArr));
                    dataOutputStream.flush();
                    dataOutputStream = new DataOutputStream(new CipherOutputStream(this.bufferedOutputStream, this.cipher));
                } catch (InvalidAlgorithmParameterException e2) {
                    e = e2;
                    throw new IllegalStateException(e);
                } catch (InvalidKeyException e3) {
                    e = e3;
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
        } catch (IOException e4) {
            e = e4;
            dataOutputStream2 = dataOutputStream;
            throw new Cache.CacheException(e);
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            Util.closeQuietly(dataOutputStream2);
            throw th;
        }
    }

    public CachedContent add(String str) {
        CachedContent cachedContent = this.keyToContent.get(str);
        if (cachedContent == null) {
            return addNew(str, -1L);
        }
        return cachedContent;
    }

    public void removeEmpty() {
        ArrayList arrayList = new ArrayList();
        for (CachedContent cachedContent : this.keyToContent.values()) {
            if (cachedContent.isEmpty()) {
                arrayList.add(cachedContent.key);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            removeEmpty((String) arrayList.get(i));
        }
    }
}
