package common.network.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import com.baidu.android.imsdk.db.TableDefine;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class b {
    private static b nux = null;
    private SQLiteDatabase mDatabase;
    private ExecutorService mExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: common.network.b.b.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, "DisasterRecoveryCache");
        }
    });

    public static void init(Context context) {
        nux = new b(context);
    }

    public static b dIL() {
        return nux;
    }

    /* loaded from: classes.dex */
    private class a implements Runnable {
        private String mIp;
        private String nuz;

        public a(String str, String[] strArr) {
            this.nuz = str;
            this.mIp = new JSONArray((Collection) Arrays.asList(strArr)).toString();
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("hostname", this.nuz);
            contentValues.put(TableDefine.UserInfoColumns.COLUMN_IP, this.mIp);
            b.this.mDatabase.insertWithOnConflict("dns_disaster_cache", null, contentValues, 5);
        }
    }

    private b(Context context) {
        this.mDatabase = new common.network.b.a(context).getWritableDatabase();
    }

    public void h(String str, String... strArr) {
        this.mExecutor.submit(new a(str, strArr));
    }

    public String[] RU(String str) {
        String[] strArr;
        Cursor query = this.mDatabase.query("dns_disaster_cache", new String[]{TableDefine.UserInfoColumns.COLUMN_IP}, String.format("%s=?", "hostname"), new String[]{str}, null, null, null);
        try {
            if (query.moveToNext()) {
                JSONArray jSONArray = new JSONArray(query.getString(query.getColumnIndex(TableDefine.UserInfoColumns.COLUMN_IP)));
                strArr = new String[jSONArray.length()];
                for (int i = 0; i < strArr.length; i++) {
                    strArr[i] = jSONArray.getString(i);
                }
            } else {
                strArr = new String[0];
            }
        } catch (Exception e) {
            strArr = new String[0];
        } finally {
            query.close();
        }
        return strArr;
    }
}
