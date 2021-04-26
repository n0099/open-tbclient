package com.bytedance.sdk.openadsdk.preload.geckox.model;

import androidx.annotation.Keep;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.searchbox.unitedscheme.SchemeDescPatchListener;
import com.bytedance.sdk.openadsdk.preload.a.a.c;
import java.util.List;
@Keep
/* loaded from: classes5.dex */
public class UpdatePackage {
    public String accessKey;
    @c(a = "channel")
    public String channel;
    @c(a = "channel_index")
    public int channelIndex;
    @c(a = "content")
    public Content content;
    @c(a = "group_name")
    public String groupName;
    public long localVersion;
    @c(a = "package_type")
    public int packageType;
    @c(a = "package_version")
    public long version;

    @Keep
    /* loaded from: classes5.dex */
    public static class Content {
        @c(a = "package")
        public Package fullPackage;
        @c(a = SchemeDescPatchListener.PATCH)
        public Package patch;
        @c(a = "strategies")
        public Strategy strategy;
    }

    @Keep
    /* loaded from: classes5.dex */
    public static final class FileType {
        public static final int COMPRESSED_FILE = 0;
        public static final int MY_ARCHIVE_FILE = 2;
        public static final int UNCOMPRESSED_FILE = 1;
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class Package {
        @c(a = "id")
        public long id;
        @c(a = "size")
        public long length;
        @c(a = PackageTable.MD5)
        public String md5;
        @Deprecated
        public String url;
        @c(a = "url_list")
        public List<String> urlList;

        public Package() {
        }

        public long getId() {
            return this.id;
        }

        public long getLength() {
            return this.length;
        }

        public String getMd5() {
            return this.md5;
        }

        public String getUrl() {
            return this.url;
        }

        public List<String> getUrlList() {
            return this.urlList;
        }

        public void setId(int i2) {
            this.id = i2;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setUrlList(List<String> list) {
            this.urlList = list;
        }

        public String toString() {
            return "Package{url='" + this.url + "', md5='" + this.md5 + "'}";
        }

        public Package(int i2, List<String> list, String str) {
            this.id = i2;
            this.urlList = list;
            this.md5 = str;
        }
    }

    @Keep
    /* loaded from: classes5.dex */
    public static class Strategy {
        @c(a = "del_if_download_failed")
        public boolean deleteIfFail;
        @c(a = "del_old_pkg_before_download")
        public boolean deleteOldPackageBeforeDownload;
        @c(a = "need_unzip")
        public boolean needUnzip;

        public Strategy(int i2) {
            this.deleteIfFail = i2 == 1;
        }

        public boolean isDeleteIfFail() {
            return this.deleteIfFail;
        }

        public boolean isDeleteOldPackageBeforeDownload() {
            return this.deleteOldPackageBeforeDownload;
        }

        public boolean isNeedUnzip() {
            return this.needUnzip;
        }

        public void setDeleteIfFail(boolean z) {
            this.deleteIfFail = z;
        }

        public void setDeleteOldPackageBeforeDownload(boolean z) {
            this.deleteOldPackageBeforeDownload = z;
        }

        public void setNeedUnzip(boolean z) {
            this.needUnzip = z;
        }
    }

    public UpdatePackage() {
    }

    public String getAccessKey() {
        return this.accessKey;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getChannelIndex() {
        return this.channelIndex;
    }

    public Package getFullPackage() {
        return this.content.fullPackage;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public long getLocalVersion() {
        return this.localVersion;
    }

    public int getPackageType() {
        return this.packageType;
    }

    public Package getPatch() {
        return this.content.patch;
    }

    public Strategy getStrategy() {
        return this.content.strategy;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean isFullUpdate() {
        return getFullPackage() != null && getFullPackage().getUrlList().size() > 0;
    }

    public boolean isPatchUpdate() {
        return getPatch() != null && getPatch().getUrlList().size() > 0;
    }

    public void setAccessKey(String str) {
        this.accessKey = str;
    }

    public void setChannel(String str) {
        this.channel = str;
    }

    public void setChannelIndex(int i2) {
        this.channelIndex = i2;
    }

    public void setFullPackage(Package r2) {
        this.content.fullPackage = r2;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setLocalVersion(long j) {
        this.localVersion = j;
    }

    public void setPatch(Package r2) {
        this.content.patch = r2;
    }

    public void setStrategy(Strategy strategy) {
        this.content.strategy = strategy;
    }

    public void setVersion(long j) {
        this.version = j;
    }

    public String toString() {
        return "UpdatePackage{version=" + this.version + ", channel='" + this.channel + "', content=" + this.content + ", packageType=" + this.packageType + '}';
    }

    public UpdatePackage(long j, String str, Package r4, Package r5) {
        this.version = j;
        this.channel = str;
        Content content = new Content();
        this.content = content;
        content.fullPackage = r4;
        this.content.patch = r5;
    }
}
