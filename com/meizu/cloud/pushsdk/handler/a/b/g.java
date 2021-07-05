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
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f40489a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40490b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f40491c;

    /* renamed from: d  reason: collision with root package name */
    public b f40492d;

    /* renamed from: e  reason: collision with root package name */
    public String f40493e;

    public g(Parcel parcel) {
        this.f40489a = parcel.readInt();
        this.f40490b = parcel.readByte() != 0;
        this.f40491c = parcel.createStringArrayList();
        this.f40492d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f40493e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f40493e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f40489a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f40490b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f40491c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f40491c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.h.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f40492d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f40489a;
    }

    public boolean b() {
        return this.f40490b;
    }

    public List<String> c() {
        return this.f40491c;
    }

    public b d() {
        return this.f40492d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f40489a + ", wifiUpload=" + this.f40490b + ", fileList=" + this.f40491c + ", controlMessage=" + this.f40492d + ", uploadMessage='" + this.f40493e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f40489a);
        parcel.writeByte(this.f40490b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f40491c);
        parcel.writeParcelable(this.f40492d, i2);
        parcel.writeString(this.f40493e);
    }
}
