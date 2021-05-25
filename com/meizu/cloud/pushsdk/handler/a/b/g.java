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
    public int f34949a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f34950b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f34951c;

    /* renamed from: d  reason: collision with root package name */
    public b f34952d;

    /* renamed from: e  reason: collision with root package name */
    public String f34953e;

    public g(Parcel parcel) {
        this.f34949a = parcel.readInt();
        this.f34950b = parcel.readByte() != 0;
        this.f34951c = parcel.createStringArrayList();
        this.f34952d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f34953e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f34953e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f34949a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f34950b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f34951c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f34951c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f34952d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f34949a;
    }

    public boolean b() {
        return this.f34950b;
    }

    public List<String> c() {
        return this.f34951c;
    }

    public b d() {
        return this.f34952d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f34949a + ", wifiUpload=" + this.f34950b + ", fileList=" + this.f34951c + ", controlMessage=" + this.f34952d + ", uploadMessage='" + this.f34953e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f34949a);
        parcel.writeByte(this.f34950b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f34951c);
        parcel.writeParcelable(this.f34952d, i2);
        parcel.writeString(this.f34953e);
    }
}
