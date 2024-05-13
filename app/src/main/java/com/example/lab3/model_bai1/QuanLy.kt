package com.example.lab3.model_bai1

fun main(){
    var listcbgv = mutableListOf<CBGV>()
    val cbgv = CBGV("GV1", "Phung Manh Hung", 20, "Ha Noi", 1500.0, 1000.0, 200.0)
    val cbgv2 = CBGV("GV2", "Hà Quang Huy", 19, "Yen Bai", 2500.0, 2000.0, 100.0)
    listcbgv.add(cbgv)
    listcbgv.add(cbgv2)

    do {
        println("1. Xem danh sách giáo viên")
        println("2. Thêm giáo viên")
        println("3. Xóa giáo viên")
        println("4. Tính lương thực lĩnh")
        print("Moi chon chuc nang: ")
        var s = readLine()!!.toInt()

        when (s) {
            1 -> {
                getThongTin(listcbgv)
            }

            2 -> {
                addGV(listcbgv)
                getThongTin(listcbgv)
            }

            3 -> {
                deleteGV(listcbgv)
                getThongTin(listcbgv)
            }

            4 -> {
                luonglinhthuc(listcbgv)
            }

            else -> println("Chuc nang khong ton tai")
        }

        print("Ban co muon tiep tuc khong? (y/n): ")
        if (readLine().equals("n"))
            break
    } while (true)
}
fun getThongTin(list: MutableList<CBGV>){
    println("Danh Sách Giáo Viên")
    for(gv in list){
        println("Mã Giáo Viên: ${gv.magv}, Họ Tên: ${gv.hoten}, Tuổi: ${gv.tuoi}, Địa Chỉ: ${gv.quequan}, " + "Lương Cứng: ${gv.luongcung}, Tiền Thưởng: ${gv.luongthuong}, Tiền Phạt: ${gv.tienphat}")
    }
}
fun addGV(listcbgv: MutableList<CBGV>){
    print("Nhập mã giáo viên: ")
    var magv = readln()
    print("Nhập họ tên giáo viên: ")
    var hoten = readln()
    print("Nhập tuổi giáo viên: ")
    var tuoi = readln()!!.toInt()
    print("Nhập quê quán: ")
    var quequan = readln()
    print("Nhập lương giáo viên: ")
    var luongcung = readln()!!.toDouble()
    print("Nhập tiền thưởng: ")
    var tienthuong = readln()!!.toDouble()
    print("Nhập tiền phạt: ")
    var tienphat = readln()!!.toDouble()
    val cbgv = CBGV(magv!!, hoten!!, tuoi, quequan!!, luongcung, tienthuong, tienphat)
    listcbgv.add(cbgv)
}

fun deleteGV(listcbgv: MutableList<CBGV>) {
    print("Nhập mã giáo viên cần xóa: ")
    var magv = readLine()

    var check = false

    for (gv in listcbgv) {
        if (gv.magv.equals(magv)) {
            listcbgv.remove(gv)
            check = true
            break
        }
    }
    if (check == false)
        println("Giao vien khong ton tai")
}
fun luonglinhthuc(listCBGV: MutableList<CBGV>) {
    for (gv in listCBGV) {
        println("Luong cua giao vien ${gv.hoten} la: ${gv.luongthuclinh()}")
    }
}