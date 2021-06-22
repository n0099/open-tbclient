package com.facebook.soloader;

import android.os.StrictMode;
import android.util.Log;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class DirectorySoSource extends SoSource {
    public static final int ON_LD_LIBRARY_PATH = 2;
    public static final int RESOLVE_DEPENDENCIES = 1;
    public final int flags;
    public final File soDirectory;

    public DirectorySoSource(File file, int i2) {
        this.soDirectory = file;
        this.flags = i2;
    }

    public static String[] getDependencies(File file) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[" + file.getName() + PreferencesUtil.RIGHT_MOUNT);
        }
        try {
            return MinElf.extract_DT_NEEDED(file);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    private void loadDependencies(File file, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        String[] dependencies = getDependencies(file);
        Log.d("SoLoader", "Loading lib dependencies: " + Arrays.toString(dependencies));
        for (String str : dependencies) {
            if (!str.startsWith("/")) {
                SoLoader.loadLibraryBySoName(str, i2 | 1, threadPolicy);
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public void addToLdLibraryPath(Collection<String> collection) {
        collection.add(this.soDirectory.getAbsolutePath());
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i2, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        return loadLibraryFrom(str, i2, this.soDirectory, threadPolicy);
    }

    public int loadLibraryFrom(String str, int i2, File file, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        File file2 = new File(file, str);
        if (!file2.exists()) {
            Log.d("SoLoader", str + " not found on " + file.getCanonicalPath());
            return 0;
        }
        Log.d("SoLoader", str + " found on " + file.getCanonicalPath());
        if ((i2 & 1) != 0 && (this.flags & 2) != 0) {
            Log.d("SoLoader", str + " loaded implicitly");
            return 2;
        }
        if ((this.flags & 1) != 0) {
            loadDependencies(file2, i2, threadPolicy);
        } else {
            Log.d("SoLoader", "Not resolving dependencies for " + str);
        }
        try {
            SoLoader.sSoFileLoader.load(file2.getAbsolutePath(), i2);
            return 1;
        } catch (UnsatisfiedLinkError e2) {
            if (e2.getMessage().contains("bad ELF magic")) {
                Log.d("SoLoader", "Corrupted lib file detected");
                return 3;
            }
            throw e2;
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        String name;
        try {
            name = String.valueOf(this.soDirectory.getCanonicalPath());
        } catch (IOException unused) {
            name = this.soDirectory.getName();
        }
        return getClass().getName() + "[root = " + name + " flags = " + this.flags + ']';
    }

    @Override // com.facebook.soloader.SoSource
    @Nullable
    public File unpackLibrary(String str) throws IOException {
        File file = new File(this.soDirectory, str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
