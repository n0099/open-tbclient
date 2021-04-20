package d.b.g0.l.j.b;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends d.b.g0.l.i.c.b<d.b.g0.l.j.a> {
    @Override // d.b.g0.l.i.c.b
    public List<d.b.g0.l.j.a> e(Cursor cursor) throws SQLException {
        ArrayList arrayList = new ArrayList();
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return arrayList;
        }
        do {
            arrayList.add(h(cursor));
        } while (cursor.moveToNext());
        return arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    /* renamed from: f */
    public ContentValues c(@NonNull d.b.g0.l.j.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Constants.APP_ID, aVar.a());
        contentValues.put("bundle_id", aVar.b());
        contentValues.put("version_name", aVar.h());
        contentValues.put("version_code", Integer.valueOf(aVar.g()));
        contentValues.put("size", Long.valueOf(aVar.f()));
        contentValues.put(PackageTable.MD5, aVar.d());
        contentValues.put("sign", aVar.e());
        contentValues.put(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, aVar.c());
        return contentValues;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.l.i.c.b
    @Nullable
    /* renamed from: g */
    public d.b.g0.l.j.a d(Cursor cursor) throws SQLException {
        if (cursor == null || cursor.getCount() <= 0 || !cursor.moveToFirst()) {
            return null;
        }
        return h(cursor);
    }

    @Nullable
    public final d.b.g0.l.j.a h(Cursor cursor) {
        if (cursor != null) {
            return d.b.g0.l.j.a.i(cursor);
        }
        return null;
    }
}
