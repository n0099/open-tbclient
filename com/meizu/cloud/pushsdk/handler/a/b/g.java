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
    public int f37692a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37693b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37694c;

    /* renamed from: d  reason: collision with root package name */
    public b f37695d;

    /* renamed from: e  reason: collision with root package name */
    public String f37696e;

    public g(Parcel parcel) {
        this.f37692a = parcel.readInt();
        this.f37693b = parcel.readByte() != 0;
        this.f37694c = parcel.createStringArrayList();
        this.f37695d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f37696e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f37696e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f37692a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f37693b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f37694c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f37694c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.h.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f37695d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f37692a;
    }

    public boolean b() {
        return this.f37693b;
    }

    public List<String> c() {
        return this.f37694c;
    }

    public b d() {
        return this.f37695d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f37692a + ", wifiUpload=" + this.f37693b + ", fileList=" + this.f37694c + ", controlMessage=" + this.f37695d + ", uploadMessage='" + this.f37696e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f37692a);
        parcel.writeByte(this.f37693b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f37694c);
        parcel.writeParcelable(this.f37695d, i2);
        parcel.writeString(this.f37696e);
    }
}
