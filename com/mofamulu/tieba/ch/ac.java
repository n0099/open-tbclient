package com.mofamulu.tieba.ch;

import android.database.Cursor;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
/* loaded from: classes.dex */
public class ac {
    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.e("tbhp_close", "error on close the inputstream.", e);
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("tbhp_close", "error on close the outputstream.", e);
            }
        }
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                Log.e("tbhp_close", "error on close the Reader.", e);
            }
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                Log.e("tbhp_close", "error on close android.database.Cursor.", e);
            }
        }
    }
}
