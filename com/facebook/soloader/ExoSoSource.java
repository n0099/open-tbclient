package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
/* loaded from: classes6.dex */
public final class ExoSoSource extends UnpackingSoSource {

    /* loaded from: classes6.dex */
    public final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        public final FileDso[] mDsos;

        /* loaded from: classes6.dex */
        public final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            public int mCurrentDso;

            public FileBackedInputDsoIterator() {
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            @Override // com.facebook.soloader.UnpackingSoSource.InputDsoIterator
            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] fileDsoArr = ExoUnpacker.this.mDsos;
                int i2 = this.mCurrentDso;
                this.mCurrentDso = i2 + 1;
                FileDso fileDso = fileDsoArr[i2];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION, THROW, THROW, THROW, INVOKE, MOVE_EXCEPTION, INVOKE, THROW, INVOKE, MOVE_EXCEPTION, MOVE_EXCEPTION] complete} */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00e4, code lost:
            throw new java.lang.RuntimeException("illegal line in exopackage metadata: [" + r11 + com.baidu.pass.main.facesdk.utils.PreferencesUtil.RIGHT_MOUNT);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ExoUnpacker(UnpackingSoSource unpackingSoSource) throws IOException {
            boolean z;
            Context context = ExoSoSource.this.mContext;
            File file = new File("/data/local/tmp/exopackage/" + context.getPackageName() + "/native-libs/");
            ArrayList arrayList = new ArrayList();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            String[] supportedAbis = SysUtil.getSupportedAbis();
            int length = supportedAbis.length;
            int i2 = 0;
            int i3 = 0;
            loop0: while (i3 < length) {
                String str = supportedAbis[i3];
                File file2 = new File(file, str);
                if (file2.isDirectory()) {
                    linkedHashSet.add(str);
                    File file3 = new File(file2, "metadata.txt");
                    if (file3.isFile()) {
                        FileReader fileReader = new FileReader(file3);
                        try {
                            BufferedReader bufferedReader = new BufferedReader(fileReader);
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.length() != 0) {
                                        int indexOf = readLine.indexOf(32);
                                        if (indexOf == -1) {
                                            break loop0;
                                        }
                                        String str2 = readLine.substring(i2, indexOf) + ".so";
                                        int size = arrayList.size();
                                        int i4 = 0;
                                        while (true) {
                                            if (i4 >= size) {
                                                z = false;
                                                break;
                                            } else if (((FileDso) arrayList.get(i4)).name.equals(str2)) {
                                                z = true;
                                                break;
                                            } else {
                                                i4++;
                                            }
                                        }
                                        if (!z) {
                                            String substring = readLine.substring(indexOf + 1);
                                            arrayList.add(new FileDso(str2, substring, new File(file2, substring)));
                                        }
                                        i2 = 0;
                                    }
                                } else {
                                    bufferedReader.close();
                                    fileReader.close();
                                    break;
                                }
                            }
                        } finally {
                        }
                    } else {
                        continue;
                    }
                }
                i3++;
                i2 = 0;
            }
            unpackingSoSource.setSoSourceAbis((String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]));
            this.mDsos = (FileDso[]) arrayList.toArray(new FileDso[arrayList.size()]);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        @Override // com.facebook.soloader.UnpackingSoSource.Unpacker
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator();
        }
    }

    /* loaded from: classes6.dex */
    public static final class FileDso extends UnpackingSoSource.Dso {
        public final File backingFile;

        public FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }

    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    @Override // com.facebook.soloader.UnpackingSoSource
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this);
    }
}
