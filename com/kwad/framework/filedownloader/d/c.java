package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.kwad.framework.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes10.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        public static c[] bz(int i) {
            return new c[i];
        }

        public static c c(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i) {
            return bz(i);
        }
    };
    public String Vz;
    public boolean ahc;
    public boolean ahp;
    public final AtomicInteger ahq;
    public final AtomicLong ahr;
    public long ahs;
    public String aht;
    public String ahu;
    public int ahv;
    public String filename;
    public int id;
    public String url;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public c() {
        this.ahr = new AtomicLong();
        this.ahq = new AtomicInteger();
    }

    private String wd() {
        return this.aht;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.Vz;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), tH(), getFilename());
    }

    public final long getTotal() {
        return this.ahs;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        if (this.ahs == -1) {
            return true;
        }
        return false;
    }

    public final boolean tH() {
        return this.ahp;
    }

    public final byte tL() {
        return (byte) this.ahq.get();
    }

    public final boolean tR() {
        return this.ahc;
    }

    public final String vt() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.bm(getTargetFilePath());
    }

    public final long wb() {
        return this.ahr.get();
    }

    public final String wc() {
        return this.ahu;
    }

    public final int we() {
        return this.ahv;
    }

    public final void wf() {
        this.ahv = 1;
    }

    public c(Parcel parcel) {
        boolean z;
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.Vz = parcel.readString();
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.ahp = z;
        this.filename = parcel.readString();
        this.ahq = new AtomicInteger(parcel.readByte());
        this.ahr = new AtomicLong(parcel.readLong());
        this.ahs = parcel.readLong();
        this.aht = parcel.readString();
        this.ahu = parcel.readString();
        this.ahv = parcel.readInt();
        this.ahc = parcel.readByte() != 0;
    }

    public final void O(long j) {
        this.ahr.set(j);
    }

    public final void P(long j) {
        this.ahr.addAndGet(j);
    }

    public final void Q(long j) {
        boolean z;
        if (j > 2147483647L) {
            z = true;
        } else {
            z = false;
        }
        this.ahc = z;
        this.ahs = j;
    }

    public final void bg(String str) {
        this.ahu = str;
    }

    public final void bh(String str) {
        this.aht = str;
    }

    public final void bi(String str) {
        this.filename = str;
    }

    public final void by(int i) {
        this.ahv = i;
    }

    public final void d(byte b) {
        this.ahq.set(b);
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final void d(String str, boolean z) {
        this.Vz = str;
        this.ahp = z;
    }

    public final String toString() {
        return f.b("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.Vz, Integer.valueOf(this.ahq.get()), this.ahr, Long.valueOf(this.ahs), this.ahu, super.toString());
    }

    public final ContentValues vZ() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put("path", getPath());
        contentValues.put("status", Byte.valueOf(tL()));
        contentValues.put("sofar", Long.valueOf(wb()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put(StatConstants.KEY_EXT_ERR_MSG, wd());
        contentValues.put("etag", wc());
        contentValues.put("connectionCount", Integer.valueOf(we()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(tH()));
        if (tH() && getFilename() != null) {
            contentValues.put(BreakpointSQLiteKey.FILENAME, getFilename());
        }
        return contentValues;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.Vz);
        parcel.writeByte(this.ahp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.ahq.get());
        parcel.writeLong(this.ahr.get());
        parcel.writeLong(this.ahs);
        parcel.writeString(this.aht);
        parcel.writeString(this.ahu);
        parcel.writeInt(this.ahv);
        parcel.writeByte(this.ahc ? (byte) 1 : (byte) 0);
    }
}
