package d.a.m0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b<T> {
    public ContentValues a(d.a.m0.n.h.e eVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bundle_id", eVar.f51794g);
        contentValues.put("category", Integer.valueOf(eVar.f51795h));
        contentValues.put("version_name", eVar.j);
        contentValues.put("version_code", Long.valueOf(eVar.f51796i));
        contentValues.put("size", Long.valueOf(eVar.k));
        contentValues.put(PackageTable.MD5, eVar.l);
        contentValues.put("sign", eVar.m);
        contentValues.put(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, eVar.n);
        contentValues.put(PackageTable.FILE_PATH, eVar.f51788a);
        contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(eVar.f51789b));
        contentValues.put("create_time", Long.valueOf(eVar.f51790c));
        contentValues.put("update_time", Long.valueOf(eVar.f51791d));
        contentValues.put("state", Integer.valueOf(eVar.f51792e));
        return contentValues;
    }

    public boolean b(Cursor cursor, d.a.m0.n.h.e eVar) {
        if (cursor != null) {
            int columnIndex = cursor.getColumnIndex("bundle_id");
            int columnIndex2 = cursor.getColumnIndex("category");
            int columnIndex3 = cursor.getColumnIndex("version_name");
            int columnIndex4 = cursor.getColumnIndex("version_code");
            int columnIndex5 = cursor.getColumnIndex("size");
            int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
            int columnIndex7 = cursor.getColumnIndex("sign");
            int columnIndex8 = cursor.getColumnIndex(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
            int columnIndex9 = cursor.getColumnIndex("_id");
            int columnIndex10 = cursor.getColumnIndex(PackageTable.FILE_PATH);
            int columnIndex11 = cursor.getColumnIndex(PackageTable.CURRENT_SIZE);
            int columnIndex12 = cursor.getColumnIndex("create_time");
            int columnIndex13 = cursor.getColumnIndex("update_time");
            int columnIndex14 = cursor.getColumnIndex("state");
            String string = cursor.getString(columnIndex);
            if (TextUtils.isEmpty(string)) {
                return false;
            }
            eVar.f51794g = string;
            eVar.f51795h = cursor.getInt(columnIndex2);
            eVar.j = cursor.getString(columnIndex3);
            eVar.f51796i = cursor.getInt(columnIndex4);
            eVar.k = cursor.getLong(columnIndex5);
            eVar.l = cursor.getString(columnIndex6);
            eVar.m = cursor.getString(columnIndex7);
            eVar.n = cursor.getString(columnIndex8);
            eVar.f51788a = cursor.getString(columnIndex10);
            eVar.f51789b = cursor.getLong(columnIndex11);
            eVar.f51790c = cursor.getLong(columnIndex12);
            eVar.f51791d = cursor.getLong(columnIndex13);
            eVar.f51793f = cursor.getLong(columnIndex9);
            eVar.f51792e = cursor.getInt(columnIndex14);
            return true;
        }
        return false;
    }

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;
}
