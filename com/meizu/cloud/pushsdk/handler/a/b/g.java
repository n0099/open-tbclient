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
    public int f38628a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38629b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38630c;

    /* renamed from: d  reason: collision with root package name */
    public b f38631d;

    /* renamed from: e  reason: collision with root package name */
    public String f38632e;

    public g(Parcel parcel) {
        this.f38628a = parcel.readInt();
        this.f38629b = parcel.readByte() != 0;
        this.f38630c = parcel.createStringArrayList();
        this.f38631d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f38632e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f38632e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f38628a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f38629b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f38630c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f38630c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f38631d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f38628a;
    }

    public boolean b() {
        return this.f38629b;
    }

    public List<String> c() {
        return this.f38630c;
    }

    public b d() {
        return this.f38631d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f38628a + ", wifiUpload=" + this.f38629b + ", fileList=" + this.f38630c + ", controlMessage=" + this.f38631d + ", uploadMessage='" + this.f38632e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f38628a);
        parcel.writeByte(this.f38629b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f38630c);
        parcel.writeParcelable(this.f38631d, i2);
        parcel.writeString(this.f38632e);
    }
}
