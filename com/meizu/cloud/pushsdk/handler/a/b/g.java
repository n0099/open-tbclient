package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.b.g.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f67632a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67633b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f67634c;

    /* renamed from: d  reason: collision with root package name */
    public b f67635d;

    /* renamed from: e  reason: collision with root package name */
    public String f67636e;

    public g(Parcel parcel) {
        this.f67632a = parcel.readInt();
        this.f67633b = parcel.readByte() != 0;
        this.f67634c = parcel.createStringArrayList();
        this.f67635d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f67636e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f67636e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f67632a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f67633b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f67634c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f67634c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            b.l.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f67635d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f67632a;
    }

    public boolean b() {
        return this.f67633b;
    }

    public List<String> c() {
        return this.f67634c;
    }

    public b d() {
        return this.f67635d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f67632a + ", wifiUpload=" + this.f67633b + ", fileList=" + this.f67634c + ", controlMessage=" + this.f67635d + ", uploadMessage='" + this.f67636e + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f67632a);
        parcel.writeByte(this.f67633b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f67634c);
        parcel.writeParcelable(this.f67635d, i2);
        parcel.writeString(this.f67636e);
    }
}
