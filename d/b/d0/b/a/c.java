package d.b.d0.b.a;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
/* loaded from: classes2.dex */
public class c implements Cursor {

    /* renamed from: e  reason: collision with root package name */
    public Bundle f42717e;

    public c(Bundle bundle) {
        this.f42717e = bundle;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    @Override // android.database.Cursor
    public void deactivate() {
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        return new byte[0];
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        return 0;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        return 0;
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        return null;
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        return new String[0];
    }

    @Override // android.database.Cursor
    public int getCount() {
        return 0;
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        return 0.0d;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.f42717e;
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        return 0.0f;
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        return 0;
    }

    @Override // android.database.Cursor
    public long getLong(int i) {
        return 0L;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return null;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        return 0;
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        return (short) 0;
    }

    @Override // android.database.Cursor
    public String getString(int i) {
        return null;
    }

    @Override // android.database.Cursor
    public int getType(int i) {
        return 0;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        return false;
    }

    @Override // android.database.Cursor
    public boolean move(int i) {
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i) {
        return false;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        return false;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    @Override // android.database.Cursor
    public boolean requery() {
        return false;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return null;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        this.f42717e = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }
}
