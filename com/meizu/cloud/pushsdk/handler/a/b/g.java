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
    public int f37831a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f37832b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f37833c;

    /* renamed from: d  reason: collision with root package name */
    public b f37834d;

    /* renamed from: e  reason: collision with root package name */
    public String f37835e;

    public g(Parcel parcel) {
        this.f37831a = parcel.readInt();
        this.f37832b = parcel.readByte() != 0;
        this.f37833c = parcel.createStringArrayList();
        this.f37834d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f37835e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f37835e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f37831a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f37832b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f37833c = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f37833c.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f37834d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f37831a;
    }

    public boolean b() {
        return this.f37832b;
    }

    public List<String> c() {
        return this.f37833c;
    }

    public b d() {
        return this.f37834d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f37831a + ", wifiUpload=" + this.f37832b + ", fileList=" + this.f37833c + ", controlMessage=" + this.f37834d + ", uploadMessage='" + this.f37835e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f37831a);
        parcel.writeByte(this.f37832b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f37833c);
        parcel.writeParcelable(this.f37834d, i);
        parcel.writeString(this.f37835e);
    }
}
