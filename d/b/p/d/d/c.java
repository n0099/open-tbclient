package d.b.p.d.d;

import android.database.AbstractCursor;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class c extends AbstractCursor {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f64994e;

    public c(Bundle bundle) {
        this.f64994e = bundle;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return new String[0];
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getCount() {
        return 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public double getDouble(int i) {
        return 0.0d;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.f64994e;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public int getInt(int i) {
        return 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public long getLong(int i) {
        return 0L;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public short getShort(int i) {
        return (short) 0;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public String getString(int i) {
        return null;
    }

    @Override // android.database.AbstractCursor, android.database.Cursor
    public boolean isNull(int i) {
        return false;
    }
}
