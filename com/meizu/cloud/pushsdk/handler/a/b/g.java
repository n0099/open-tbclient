package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
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
        public g[] newArray(int i) {
            return new g[i];
        }
    };
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42178b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f42179c;

    /* renamed from: d  reason: collision with root package name */
    public b f42180d;

    /* renamed from: e  reason: collision with root package name */
    public String f42181e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.f42178b = parcel.readByte() != 0;
        this.f42179c = parcel.createStringArrayList();
        this.f42180d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f42181e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f42181e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f42178b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f42179c = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f42179c.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e2) {
            c.h.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f42180d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.f42178b;
    }

    public List<String> c() {
        return this.f42179c;
    }

    public b d() {
        return this.f42180d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.f42178b + ", fileList=" + this.f42179c + ", controlMessage=" + this.f42180d + ", uploadMessage='" + this.f42181e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.f42178b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f42179c);
        parcel.writeParcelable(this.f42180d, i);
        parcel.writeString(this.f42181e);
    }
}
