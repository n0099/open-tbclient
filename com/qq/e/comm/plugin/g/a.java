package com.qq.e.comm.plugin.g;

import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private String f12290a;

    public a(Context context) {
        this(context, "gdt_database");
    }

    public a(Context context, String str) {
        super(context);
        this.f12290a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public File getDatabasePath(String str) {
        File file;
        File filesDir = getFilesDir();
        if (filesDir == null) {
            File databasePath = super.getDatabasePath(str);
            GDTLogger.d("getDatabasePath(" + str + ") = " + (databasePath != null ? databasePath.getPath() : null));
            return databasePath;
        }
        if (this.f12290a != null) {
            File file2 = new File(filesDir, this.f12290a);
            if (file2.exists() || file2.mkdir()) {
                filesDir = file2;
            }
        }
        File file3 = new File(filesDir, str);
        if (!file3.exists()) {
            GDTLogger.d("create database file");
            try {
            } catch (IOException e) {
                e.printStackTrace();
                file = super.getDatabasePath(str);
            }
            if (!file3.createNewFile()) {
                file = super.getDatabasePath(str);
                GDTLogger.d("getDatabasePath(" + str + ") = " + (file != null ? file.getPath() : null) + ", this:" + this);
                return file;
            }
        }
        file = file3;
        GDTLogger.d("getDatabasePath(" + str + ") = " + (file != null ? file.getPath() : null) + ", this:" + this);
        return file;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return openOrCreateDatabase(str, i, cursorFactory, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        SQLiteDatabase openOrCreateDatabase;
        int i2 = 268435456;
        if ((i & 8) != 0 && Build.VERSION.SDK_INT >= 16) {
            i2 = 805306368;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            File databasePath = getDatabasePath(str);
            openOrCreateDatabase = databasePath != null ? SQLiteDatabase.openDatabase(databasePath.getPath(), cursorFactory, i2, databaseErrorHandler) : null;
        } else {
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(getDatabasePath(str), cursorFactory);
        }
        GDTLogger.d("openOrCreateDatabase(" + str + ",,) = " + (openOrCreateDatabase != null ? openOrCreateDatabase.getPath() : null));
        return openOrCreateDatabase;
    }
}
