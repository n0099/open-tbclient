package com.kwad.sdk.collector;

import android.content.Context;
import android.os.Build;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.j;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class UploadEntry implements Serializable {
    public static final String LOCAL_TEMP_UPLOAD_FAILURE = "LOCAL_TEMP_UPLOAD_FAILURE";
    public static final String TEMP_ZIP_FILE_PATH_SUFFIX = "tempUploadZipFile_";
    public static Charset UTF_8 = Charset.forName("UTF-8");
    public static final long serialVersionUID = 8380766597841287184L;
    public File originFile;
    public String packageName;
    public String uploadFileName;
    public File zipFile;

    public UploadEntry(Context context, String str, File file) {
        this.packageName = str;
        this.originFile = file;
        String absolutePath = file.getAbsolutePath();
        String substring = absolutePath.substring(absolutePath.indexOf(str));
        this.uploadFileName = substring;
        String replace = substring.replace("/", "_");
        this.zipFile = new File(context.getApplicationInfo().dataDir, TEMP_ZIP_FILE_PATH_SUFFIX + str + replace);
    }

    @WorkerThread
    private String getFileBase64() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new String(com.kwad.sdk.core.b.c.a().a(j.a(l.b(this.originFile))));
        }
        return null;
    }

    public static ArrayList<UploadEntry> readFailureListFromLocal(Context context) {
        ObjectInputStream objectInputStream;
        FileInputStream fileInputStream;
        File file = new File(context.getApplicationInfo().dataDir, LOCAL_TEMP_UPLOAD_FAILURE);
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                } catch (Throwable unused) {
                    objectInputStream = null;
                }
            } catch (Throwable unused2) {
                objectInputStream = null;
                fileInputStream = null;
            }
            try {
                ArrayList<UploadEntry> arrayList = (ArrayList) objectInputStream.readObject();
                com.kwad.sdk.crash.utils.b.a(fileInputStream, objectInputStream);
                return arrayList;
            } catch (Throwable unused3) {
                com.kwad.sdk.crash.utils.b.a(fileInputStream, objectInputStream);
                return null;
            }
        }
        return null;
    }

    public static void saveFailureListToLocal(Context context, ArrayList<UploadEntry> arrayList) {
        ObjectOutputStream objectOutputStream;
        File file = new File(context.getApplicationInfo().dataDir, LOCAL_TEMP_UPLOAD_FAILURE);
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException unused) {
        }
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream2);
            } catch (Throwable unused2) {
                objectOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(arrayList);
                com.kwad.sdk.crash.utils.b.a(fileOutputStream2, objectOutputStream);
            } catch (Throwable unused3) {
                fileOutputStream = fileOutputStream2;
                com.kwad.sdk.crash.utils.b.a(fileOutputStream, objectOutputStream);
            }
        } catch (Throwable unused4) {
            objectOutputStream = null;
        }
    }

    public void cleanTempFile() {
        File file = this.zipFile;
        if (file == null || !file.exists()) {
            return;
        }
        this.zipFile.delete();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UploadEntry.class != obj.getClass()) {
            return false;
        }
        UploadEntry uploadEntry = (UploadEntry) obj;
        String str = this.packageName;
        if (str == null ? uploadEntry.packageName == null : str.equals(uploadEntry.packageName)) {
            File file = this.originFile;
            File file2 = uploadEntry.originFile;
            return file != null ? file.equals(file2) : file2 == null;
        }
        return false;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        String str = this.packageName;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        File file = this.originFile;
        return hashCode + (file != null ? file.hashCode() : 0);
    }

    @WorkerThread
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "packageName", this.packageName);
        o.a(jSONObject, "content", getFileBase64());
        o.a(jSONObject, "fileName", this.uploadFileName);
        return jSONObject;
    }

    public String toString() {
        return "UploadEntry{packageName='" + this.packageName + "', originFile=" + this.originFile + ", zipFile=" + this.zipFile + '}';
    }
}
