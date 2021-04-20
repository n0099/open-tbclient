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
    public int f38121a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38122b;

    /* renamed from: c  reason: collision with root package name */
    public List<String> f38123c;

    /* renamed from: d  reason: collision with root package name */
    public b f38124d;

    /* renamed from: e  reason: collision with root package name */
    public String f38125e;

    public g(Parcel parcel) {
        this.f38121a = parcel.readInt();
        this.f38122b = parcel.readByte() != 0;
        this.f38123c = parcel.createStringArrayList();
        this.f38124d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f38125e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f38125e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(TiebaPrepareImageService.MAX_SIZE)) {
                this.f38121a = jSONObject.getInt(TiebaPrepareImageService.MAX_SIZE);
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.f38122b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f38123c = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f38123c.add(jSONArray.getString(i));
                }
            }
        } catch (JSONException e2) {
            d.j.a.a.a.b("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f38124d = new b(str2, str3, str4);
    }

    public int a() {
        return this.f38121a;
    }

    public boolean b() {
        return this.f38122b;
    }

    public List<String> c() {
        return this.f38123c;
    }

    public b d() {
        return this.f38124d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.f38121a + ", wifiUpload=" + this.f38122b + ", fileList=" + this.f38123c + ", controlMessage=" + this.f38124d + ", uploadMessage='" + this.f38125e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f38121a);
        parcel.writeByte(this.f38122b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f38123c);
        parcel.writeParcelable(this.f38124d, i);
        parcel.writeString(this.f38125e);
    }
}
