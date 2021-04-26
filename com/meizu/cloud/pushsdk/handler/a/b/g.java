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
    public int f35775a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35776b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f35777c;

    /* renamed from: d  reason: collision with root package name */
    public b f35778d;

    /* renamed from: e  reason: collision with root package name */
    public String f35779e;

    public g(Parcel parcel) {
        this.f35775a = parcel.readInt();
        this.f35776b = parcel.readByte() != 0;
        this.f35777c = parcel.createStringArrayList();
        this.f35778d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f35779e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f35779e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f35775a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f35776b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f35777c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f35777c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f35778d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f35775a;
    }

    public boolean b() {
        return this.f35776b;
    }

    public List<String> c() {
        return this.f35777c;
    }

    public b d() {
        return this.f35778d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f35775a + ", wifiUpload=" + this.f35776b + ", fileList=" + this.f35777c + ", controlMessage=" + this.f35778d + ", uploadMessage='" + this.f35779e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f35775a);
        parcel.writeByte(this.f35776b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f35777c);
        parcel.writeParcelable(this.f35778d, i2);
        parcel.writeString(this.f35779e);
    }
}
