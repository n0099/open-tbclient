package com.meizu.cloud.pushsdk.handler.a.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
    public int f37503a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37504b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37505c;

    /* renamed from: d  reason: collision with root package name */
    public b f37506d;

    /* renamed from: e  reason: collision with root package name */
    public String f37507e;

    public g(Parcel parcel) {
        this.f37503a = parcel.readInt();
        this.f37504b = parcel.readByte() != 0;
        this.f37505c = parcel.createStringArrayList();
        this.f37506d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f37507e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f37507e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f37503a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f37504b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f37505c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f37505c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.h.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f37506d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f37503a;
    }

    public boolean b() {
        return this.f37504b;
    }

    public List<String> c() {
        return this.f37505c;
    }

    public b d() {
        return this.f37506d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f37503a + ", wifiUpload=" + this.f37504b + ", fileList=" + this.f37505c + ", controlMessage=" + this.f37506d + ", uploadMessage='" + this.f37507e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f37503a);
        parcel.writeByte(this.f37504b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f37505c);
        parcel.writeParcelable(this.f37506d, i2);
        parcel.writeString(this.f37507e);
    }
}
