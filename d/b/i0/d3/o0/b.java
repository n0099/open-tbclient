package d.b.i0.d3.o0;

import android.database.Cursor;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TiebaDatabase;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.util.Date;
/* loaded from: classes5.dex */
public class b {
    public static void a() {
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (mainDBDatabaseManager != null) {
            mainDBDatabaseManager.d("CREATE TABLE IF NOT EXISTS video_block_upload_data('md5' text,'last_upload_id' text ,'last_upload_success_index' integer,'account' text,'time' long)");
        }
    }

    public static void b(String str) {
        BdLog.e("deleteVieoChunkUploadData Called");
        if (TbadkCoreApplication.getCurrentAccount() == null) {
            return;
        }
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        if (str == null || mainDBDatabaseManager == null) {
            return;
        }
        mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
    }

    public static c c(String str) {
        c cVar;
        Exception e2;
        Cursor cursor;
        Cursor cursor2 = null;
        c cVar2 = null;
        if (TbadkCoreApplication.getCurrentAccount() == null || StringUtils.isNull(str)) {
            return null;
        }
        d.b.c.a.k.b mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager();
        try {
            cursor = mainDBDatabaseManager.j("select * from video_block_upload_data where md5=? and account=? and strftime('%s','now') - time < 48 * 3600", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
            try {
                try {
                    if (cursor.moveToFirst()) {
                        cVar = new c();
                        try {
                            cVar.f54976a = cursor.getString(cursor.getColumnIndex("last_upload_id"));
                            cVar.f54977b = cursor.getInt(cursor.getColumnIndex("last_upload_success_index"));
                            cVar2 = cVar;
                        } catch (Exception e3) {
                            e2 = e3;
                            mainDBDatabaseManager.i(e2, "getChunkUploadDataByMd5");
                            d.b.c.e.m.a.a(cursor);
                            return cVar;
                        }
                    }
                    d.b.c.e.m.a.a(cursor);
                    return cVar2;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    d.b.c.e.m.a.a(cursor2);
                    throw th;
                }
            } catch (Exception e4) {
                cVar = null;
                e2 = e4;
            }
        } catch (Exception e5) {
            cVar = null;
            e2 = e5;
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.c.e.m.a.a(cursor2);
            throw th;
        }
    }

    public static boolean d(String str, String str2, int i) {
        d.b.c.a.k.b mainDBDatabaseManager;
        if (TbadkCoreApplication.getCurrentAccount() == null || (mainDBDatabaseManager = TiebaDatabase.getInstance().getMainDBDatabaseManager()) == null) {
            return false;
        }
        Date date = new Date();
        mainDBDatabaseManager.e("delete from video_block_upload_data where md5=? and account=?", new String[]{str, TbadkCoreApplication.getCurrentAccount()});
        return mainDBDatabaseManager.e("Insert into video_block_upload_data(md5,last_upload_id,last_upload_success_index,account,time) values(?,?,?,?,?)", new Object[]{str, str2, Integer.valueOf(i), TbadkCoreApplication.getCurrentAccount(), Long.valueOf(date.getTime() / 1000)});
    }
}
