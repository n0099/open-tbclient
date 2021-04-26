package d.a.j0.q.f;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.addresslist.relationship.RequestGetAddressListMessage;
/* loaded from: classes4.dex */
public class g extends SQLiteOpenHelper {
    public g(Context context) {
        super(context, "relationship.db", (SQLiteDatabase.CursorFactory) null, 4);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                return;
            }
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS table_" + currentAccount + "(name TEXT NOT NULL UNIQUE, id LONG, name_show TEXT, portrait TEXT, quanpin TEXT, first_letter TEXT, location_hide INT, location_distance TEXT, location_time LONG, user_type INT);");
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "RelationshipDbHelper.createTables", new Object[0]);
            BdLog.e("create table wrong " + e2.toString());
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        try {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (TextUtils.isEmpty(currentAccount)) {
                return;
            }
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS table_" + currentAccount);
        } catch (Exception e2) {
            TiebaStatic.printDBExceptionLog(e2, "RelationshipDbHelper.dropTables", new Object[0]);
            BdLog.e("drop table wrong " + e2.toString());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        b(sQLiteDatabase);
        a(sQLiteDatabase);
        try {
            MessageManager.getInstance().sendMessageFromBackground(new RequestGetAddressListMessage(304001));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }
}
