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
        public g[] newArray(int i) {
            return new g[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f37832a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37833b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37834c;

    /* renamed from: d  reason: collision with root package name */
    public b f37835d;

    /* renamed from: e  reason: collision with root package name */
    public String f37836e;

    public g(Parcel parcel) {
        this.f37832a = parcel.readInt();
        this.f37833b = parcel.readByte() != 0;
        this.f37834c = parcel.createStringArrayList();
        this.f37835d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f37836e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f37836e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f37832a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f37833b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f37834c = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f37834c.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f37835d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f37832a;
    }

    public boolean b() {
        return this.f37833b;
    }

    public List<String> c() {
        return this.f37834c;
    }

    public b d() {
        return this.f37835d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f37832a + ", wifiUpload=" + this.f37833b + ", fileList=" + this.f37834c + ", controlMessage=" + this.f37835d + ", uploadMessage='" + this.f37836e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f37832a);
        parcel.writeByte(this.f37833b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f37834c);
        parcel.writeParcelable(this.f37835d, i);
        parcel.writeString(this.f37836e);
    }
}
